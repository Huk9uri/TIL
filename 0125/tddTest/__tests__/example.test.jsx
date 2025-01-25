/* eslint-disable no-undef */
import plus from "../src/components/testing/plus";

test("should return 3 when 1 and 2 are added", () => {
  //given
  const a = 1;
  const b = 2;

  // when
  const result = plus(a, b);

  //then
  expect(result).toBe(3);
});
