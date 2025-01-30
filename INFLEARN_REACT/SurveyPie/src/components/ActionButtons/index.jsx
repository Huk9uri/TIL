import { useNavigate } from "react-router-dom";
import Button from "../Button";

import styled from "styled-components";
import { useRecoilValue } from "recoil";
import useStep from "../../hooks/useStep";
import questionsLengthState from "../../stores/survey/questionsLengthState";
import useSurveyId from "../../hooks/useSurveyId";
import postAnswers from "../../services/postAnswers";
import useAnswers from "../../hooks/useAnswers";
import { useState } from "react";
import useRequiredOption from "../../hooks/useRequiredOption";

function ActionButtons() {
  const step = useStep();
  const surveyId = useSurveyId();
  const [answers, setAnswers] = useAnswers();
  const [isPosting, setIsPosting] = useState(false);
  const questionsLength = useRecoilValue(questionsLengthState);
  const isRequired = useRequiredOption();

  const isLast = step === questionsLength - 1;
  const navigate = useNavigate();
  return (
    <ActionButtonsWrapper>
      {step === 0 || (
        <Button
          type="TERTIARY"
          onClick={() => {
            navigate(`/survey/${surveyId}/${step - 1}`);
          }}
        >
          이전
        </Button>
      )}
      {isLast ? (
        <Button
          type="PRIMARY"
          onClick={() => {
            setIsPosting(true);
            postAnswers(surveyId, answers)
              .then(() => {
                setAnswers([]);
                navigate(`/done/${surveyId}`);
              })
              .catch((err) => {
                console.log(err);
                alert("에러가 발생했습니다. 다시 시도해주세요.");
                setIsPosting(false);
              });
          }}
          disabled={isPosting || isRequired ? !answers[step]?.length : false}
        >
          {isPosting ? "제출 중입니다..." : "제출"}
        </Button>
      ) : (
        <Button
          type="PRIMARY"
          onClick={() => {
            console.log("next");
            navigate(`/survey/${surveyId}/${step + 1}`);
          }}
          disabled={isRequired ? !answers[step]?.length : false}
        >
          다음
        </Button>
      )}
    </ActionButtonsWrapper>
  );
}
const ActionButtonsWrapper = styled.div`
  margin-top: 72px;
  text-align: center;
  display: flex;
  gap: 16px;
  justify-content: center;
`;

export default ActionButtons;
