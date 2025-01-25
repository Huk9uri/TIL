import ActionButtons from "../ActionButtons";
import Body from "../Body";
import Desc from "../Desc";
import Title from "../Title";

// eslint-disable-next-line react/prop-types
function QuestionBox({ question, questionLength, step }) {
  return (
    <>
      <div>QuestionBox</div>
      <Title>{question.questionTitle}</Title>
      <Desc>{question.questionDesc}</Desc>
      <Body questionType={question.questionType}></Body>
      <ActionButtons
        questionLength={questionLength}
        step={step}
      ></ActionButtons>
    </>
  );
}

export default QuestionBox;
