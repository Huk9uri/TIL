//status = 'pending' | 'in-progress' | 'done'

import styled from "styled-components";
const Bar = styled.div`
  border-radius: 16px;
  height: 8px;
  width: 120px;
  background-color: ${({ status }) => {
    if (status === "pending") {
      return `#E3E2E7`;
    } else if (status === "in-progress") {
      return `#6542F1`;
    } else if (status === "done") {
      return `#BAA9FF`;
    }
  }};
`;
export default Bar;
