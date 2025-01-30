import { selector } from "recoil";
import getSurvey from "../../services/apis/getSurvey";

const surveyState = selector({
  key: "surveyState",
  get: async () => {
    const res = await getSurvey(window.location.pathname.split("/")[2]);
    return res.data;
  },
});

export default surveyState;
