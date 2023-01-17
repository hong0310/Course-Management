export default function Course({ myCourse, handleCourseClick }) {
  return (
    <div>
      <div>
        {myCourse.courseName}{" "}
        <button
          class="btn btn-outline-primary"
          onClick={(e) => handleCourseClick(myCourse.id)}
        >
          Details
        </button>
      </div>
    </div>
  );
}
