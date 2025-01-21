import { useState } from "react";
import ProgressIndicator from "./components/ProgressIndicator/ProgressIndicator";
import QuestionBox from "./components/QuestionBox/QuestionBox";

function App() {
  const questions = [
    {
      title: "질문 1입니다.",
      desc: "설명 1입니다.",
      type: "text",
      required: false,
      options: {},
    },
    {
      title: "질문 2입니다.",
      desc: "설명 2입니다.",
      type: "text",
      required: true,
      options: {},
    },
  ];

  const step = 0;

  const [answers, setAnswers] = useState([]);

  return (
    <div className="App">
      <ProgressIndicator />
      <QuestionBox
        question={questions[step]}
        questionsLength={questions.length}
        step={step}
        answers={answers[step]}
        setAnswers={(newAnswer) => {
          setAnswers((answers) => {
            const newAnswers = [...answers];
            newAnswers[step] = newAnswer;
            return newAnswers;
          });
        }}
      />
    </div>
  );
}

export default App;
