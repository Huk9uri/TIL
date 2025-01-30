import mainApi from "./MainApi";

function getSurvey(surveyId) {
  return mainApi.get(`/surveys/${surveyId}`);
}

export default getSurvey;
