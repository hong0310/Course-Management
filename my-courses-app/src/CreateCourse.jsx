import axios from "axios";
import { useRef } from "react";

export default function CreateCourse() {
  const codeElement = useRef(null);
  const nameElement = useRef(null);
  const desElement = useRef(null);

  function handleCreateClick(e) {
    e.preventDefault();

    const data = {
      code: codeElement.current.value,
      courseName: nameElement.current.value,
      description: desElement.current.value,
    };

    axios
      .post("http://localhost:8080/api/courses", data)
      .then((response) => {
        console.log(response.data);
      })
      .catch((e) => {
        console.log(e.response);
      });
  }

  return (
    <div class="container">
      <h4>Create a new course</h4>
      <form>
        <div class="form-group">
          <label htmlFor="code">Code: </label>
          <br />
          <input
            class="form-control"
            type="text"
            name="code"
            ref={codeElement}
            placeholder="Enter the course code"
            required="required"
          />
          <br />
          <label htmlFor="name">Name: </label>
          <br />
          <input
            class="form-control"
            type="text"
            name="name"
            ref={nameElement}
            placeholder="Enter the course name"
            required="required"
          />
          <br />
          <label htmlFor="description">Description: </label>
          <br />
          <input
            class="form-control"
            type="text"
            name="description"
            ref={desElement}
            placeholder="Enter the course description"
            required="required"
          />
          <br />
        </div>
        <button
          class="btn btn-primary"
          type="submit"
          onClick={handleCreateClick}
        >
          Create
        </button>
      </form>
    </div>
  );
}
