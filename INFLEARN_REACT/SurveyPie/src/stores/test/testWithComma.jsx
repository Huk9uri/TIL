import { selector } from "recoil";
import testState from "./atom";

const testWithComma = selector({
  key: "testWithComma", // unique ID (with respect to other atoms/selectors)
  get: ({ get }) => {
    const abcdArr = get(testState);

    return abcdArr.join(",");
  },
});

export default testWithComma;
