import logo from "./logo.svg";
import "./App.css";
import Course from "./Course";
import ListCourse from "./ListCourse";
import CreateCourse from "./CreateCourse";
import { BrowserRouter, Link, Route, Routes } from "react-router-dom";

function App() {
  function getNavigationHtml() {
    return (
      <nav className="py-2 bg-light border-bottom">
        <div className="container d-flex flex-wrap">
          <ul className="nav me-auto">
            <li className="nav-item">
              <Link className="nav-link" to={"/"}>
                Home
              </Link>
            </li>
            <li className="nav-item">
              <Link className="nav-link" to={"/list-course"}>
                Courses
              </Link>
            </li>
            <li className="nav-item">
              <Link className="nav-link" to={"/create-course"}>
                Create
              </Link>
            </li>
          </ul>
        </div>
      </nav>
    );
  }

  return (
    <BrowserRouter>
      {getNavigationHtml()}

      <div>
        <h2 className="container">My Course List</h2>
        <Routes>
          <Route path="/" element={<ListCourse />} />
          <Route path="/list-course" element={<ListCourse />} />
          <Route path="/create-course" element={<CreateCourse />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;
