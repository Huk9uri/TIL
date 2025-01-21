import TextInput from "../TextInput/TextInput";

function Body({ type, answer, setAnswer }) {
  let InputComponent = null;

  if (type === "select") {
    // InputComponent = SelectInput;
  } else if (type === "text") {
    InputComponent = TextInput;
  } else if (type === "textarea") {
    // InputComponent = TextArea;
  }

  return (
    <>
      <InputComponent answer={answer} setAnswer={setAnswer} />
    </>
  );
}
export default Body;
