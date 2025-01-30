import ActionButtons from "../ActionButtons";
import Body from "../Body";
import Desc from "../Desc";
import Title from "../Title";
import styled from "styled-components";
import useCurrentQuestion from "../../hooks/useCurrentQuestion";
import useCurrentAnswer from "../../hooks/useCurrentAnswer";

function QuestionBox() {
  const [answer, setAnswer] = useCurrentAnswer();
  const question = useCurrentQuestion(); // undefined

  if (!question) {
    return null;
  }

  return (
    <QuestionBoxWrapper>
      <Title>{question.title}</Title>
      <Desc>{question.desc}</Desc>
      <Body
        type={question.type}
        options={question.options}
        answer={answer}
        setAnswer={setAnswer}
      />
      <ActionButtons />
    </QuestionBoxWrapper>
  );
}
const QuestionBoxWrapper = styled.div`
  display: flex;
  flex-direction: column;
  height: 100%;
`;

export default QuestionBox;
