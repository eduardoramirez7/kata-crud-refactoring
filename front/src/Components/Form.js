import React, { useContext, useRef, useState } from "react";
import Store from "./Store";
import { Button } from "react-bootstrap";

const HOST_API = "http://localhost:8080/api";

const Form = () => {
  const formRef = useRef(null);
  const {
    dispatch,
    state: { todo },
  } = useContext(Store);
  const item = todo.item;
  const [state, setState] = useState(item);

  const onAdd = (event) => {
    event.preventDefault();

    const request = {
      name: state.name,
      id: null,
      completed: false,
    };

    fetch(HOST_API + "/api/todo", {
      method: "POST",
      body: JSON.stringify(request),
      headers: {
        "Content-Type": "application/json",
      },
    })
      .then((response) => response.json())
      .then((todo) => {
        dispatch({ type: "add-item", item: todo });
        setState({ name: "" });
        formRef.current.reset();
      });
  };

  const onEdit = (event) => {
    event.preventDefault();

    const request = {
      name: state.name,
      id: item.id,
      isCompleted: item.isCompleted,
    };

    fetch(HOST_API + "/api/todo", {
      method: "PUT",
      body: JSON.stringify(request),
      headers: {
        "Content-Type": "application/json",
      },
    })
      .then((response) => response.json())
      .then((todo) => {
        dispatch({ type: "update-item", item: todo });
        setState({ name: "" });
        formRef.current.reset();
      });
  };

  return (
    <div>
      <div className="mb-3" style={{
            display: "flex",
            flexDirection: "row",
            alignItems: "center"}}>
      <input
        type="text"
        name="name"
        placeholder="Nueva Lista"
        margin="4px"
      ></input>
      <Button style={{margin: 10}} variant="secondary" size="sm" onClick={onEdit}>
        Nueva Lista
      </Button>
      </div>
      <hr/>
      <div>
        <form
          style={{
            display: "flex",
            flexDirection: "row",
            alignItems: "center",
          }}
          ref={formRef}
        >
          <div className="mb-2">
            <input
              type="text"
              name="name"
              placeholder="Nueva Tarea"
              defaultValue={item.name}
              onChange={(event) => {
                setState({ ...state, name: event.target.value });
              }}
            ></input>
          </div>
          <div className="mb-2">
            {item.id && (
              <Button style={{margin: 10}} variant="secondary" size="sm" onClick={onEdit}>
                Actualizar Tarea
              </Button>
            )}
            {!item.id && (
              <Button style={{margin: 10}} variant="primary" size="sm" onClick={onAdd}>
                Crear Tarea
              </Button>
            )}
          </div>
        </form>
      </div>
    </div>
  );
};

export default Form;
