import { useRecoilState } from "recoil";
import answersState from "../stores/answers/atoms";

function useAnswers() {
  return useRecoilState(answersState);
}

export default useAnswers;
