import TextInput from "../TextInput";

function Body({ questionType }) {
  let InputComponent = null;

  if (questionType === "selectOption") {
    //  InputComponent =
  } else if (questionType === "text") {
    InputComponent = <input />;
  } else if (questionType === "textArea") {
    InputComponent = <textarea></textarea>;
  }
  return (
    <>
      <div>{InputComponent}</div>
    </>
  );
}

export default Body;
