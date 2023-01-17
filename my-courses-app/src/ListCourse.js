import { useState, useEffect } from "react";
import Course from "./Course";
import axios from "axios";

export default function ListCourse() {
  const [detailId, updateDetailId] = useState("");
  const [myCourseList, updateMyCourseList] = useState([]);

  useEffect(() => {
    console.log("Retrive the courses");
    axios
      .get("http://localhost:8080/api/courses")
      .then((response) => {
        updateMyCourseList(response.data);
        console.log(response.data);
      })
      .catch((e) => {
        console.log(e);
      });
  }, []);

  function handleCourseClick(id) {
    console.log("Course id " + id);
    updateDetailId(id);
  }

  const listCourseHtml = myCourseList.map((course) => (
    <div key={course.id}>
      <Course myCourse={course} handleCourseClick={handleCourseClick} />
      <br />
    </div>
  ));

  function getDetailCourseHtml() {
    // Get the course object from the detailId
    const detailCourse = myCourseList.find((course) => course.id === detailId);

    // Return the object rendering
    if (detailCourse) {
      return (
        <div class="container">
          <h4>Detail Course</h4>
          <div>Code: {detailCourse.code}</div>
          <div>Course Name: {detailCourse.courseName}</div>
          <div>Description: {detailCourse.description}</div>
        </div>
      );
    } else {
      return <></>;
    }
  }

  return (
    <div class="container">
      {listCourseHtml}
      {getDetailCourseHtml()}
    </div>
  );
}
