import ActionButtons from "../ActionButtons/ActionButtons";
import Body from "../Body/Body";
import Desc from "../Desc/Desc";
import Title from "../Title/Title";

function QuestionBox({ question, questionsLength, step, answers, setAnswers }) {
  return (
    <div>
      <Title>{question.title}</Title>
      <Desc>{question.desc}</Desc>
      <Body type={question.type} />
      <ActionButtons
        questionsLength={questionsLength}
        step={step}
        answers={answers}
        setAnswers={setAnswers}
      />
    </div>
  );
}
export default QuestionBox;
