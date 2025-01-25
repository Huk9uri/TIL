import { useState } from "react";
import "./App.css";
import ProgressIndicator from "./component/ProgressIndicator";
import QuestionBox from "./component/QuestionBox";

function App() {
  const [step, setStep] = useState(2);
  const [questions, setQuestions] = useState([
    {
      questionTitle: "질문 제목1",
      questionDesc: "질문 설명1",
      questionType: "text",
    },
    {
      questionTitle: "질문 제목2",
      questionDesc: "질문 설명2",
      questionType: "textArea",
    },
    {
      questionTitle: "질문 제목3",
      questionDesc: "질문 설명3",
      questionType: "selectOption",
    },
  ]);

  return (
    <div className="App">
      <div>step : {step}</div>
      <ProgressIndicator step={step} />
      <QuestionBox
        question={questions[step]}
        questionLength={questions.length}
        step={step}
      />
    </div>
  );
}

export default App;
