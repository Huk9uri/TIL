import mainApi from "./apis/MainApi";

function postAnswers(surveyId, data) {
  return mainApi.post(`/answers`, { surveyId, data });
}

export default postAnswers;
