# Day01_React

### React

**웹 개발을 쉽게할 수 있도록 도와주는 JavaScript 라이브러리**
- 프레임워크 : 개발을 위한 기본 툴, 뼈대
- 라이브러리 : 개발을 위한 도구, 도구의 집합 전체

### React를 쓰는 이유

**1. 컴포넌트 기반 설계**
- 재사용성 및 유지보수성 증가

**2. 가상 돔**
- 실제 DOM에서의 변경을 통한 비효율을 해결하기 위해 실제 DOM의 복사본인 가상 DOM에서의 수정을 진행하고 실제 DOM과 동기화 진행

**3. 그 외**
- CSR 방식의 랜더링
- SPA로 전통적인 웹 서비스의 문제를 해결

### JSX

**JavaScript XML, HTML + JavaScript**

**특징**
- JSX 내에서 사용되는 태그 속성의 이름이 다름 (class → className)
- 태그를 명시적으로 닫아줘야 함
- 하나의 태그로 감싸야 함



### JSX에서의 반복문

**기본적으로 KEY 라는 프로퍼티가 필요하다**

- index를 KEY로 사용할 수 있지만, React 에서는 이를 권장하지 않는다. INDEX가 변경되면 순서가 바뀐 게 아닌 요소가 변경되었다고 판단하기 때문에. 리스트의 순서가 변경되지 않는다고 보장되는 경우에는 사용해도 괜찮다.  

# State

### 변수의 변화를 감지하여 반영하기 위한 특수한 변수

React 라이브러리 안에 포함되어 있는 useState 함수를 사용한다.
useState 함수는 컴포넌트의 state를 생성하는 Hook

**구조분해할당으로 가져오기**
```
import { useState } from "react";

export default function App() {

  const [value, setValue] = useState(0); 

<!-- useState(0) 으로 value의 초기값을 0으로 설정해준다.-->

  return (
    <div>
      <h1>value: {value}</h1>
      <button
        onClick={() => {
          console.log("Increase", value);
          setValue(value + 1);
          console.log("Increase", value);
        }}
      >
        Increase value
      </button>
      <button
        onClick={() => {
          setValue(0);
        }}
      >
        Reset value
      </button>
    </div>
  );
}
```
```
console.log("Increase1", value);
setValue(value + 1);
console.log("Increase2", value);
```
Increase2는 setValue를 통한 value 값을 1 증가한 다음에 `console`에 출력하지만, Increase1, Increase2 모두 같은 값이다. 그 이유는 `setValue` 함수는 value 값을 바로 증감시키는 것이 아니라, 모든 렌더링이 끝나고, **_즉 로직들이 모두 실행 되고나서_** 한번에 처리하기 때문이다.


# Hooks

### useState

**배열을 return 하는 Hook**

- 첫번째 요소는 state 값이고 두번째 요소는 해당 state를 set 하는 setter 함수

```
const [value, setValue] = useState(0); 
```

### useEffect
**컴포넌트가 랜더링 될 때, 현재 상태 변화에 따라 조건적으로 특정 작업을 실행하기 위한 Hook**

```
  useEffect(() => {
    console.log("[Function] useEffect []: 컴포넌트가 마운트 될 때, 한 번만!");

    const eventHandler = () => {
      console.log("click body");
    };
    document.body.addEventListener("click", eventHandler);

    return () => {
      console.log("[Function] useEffect return []: 컴포넌트가 언마운트 될 때,");
    };
    document.body.removeEventListener("click", eventHandler);
  }, []);
```

**컴포넌트의 상태 변화에 따라 특정 로직 실행**

useEffect의 두번째 인자(Dependecy List)에 빈 배열이 아닌 `value`를 전달하면 `value`의 값이 변경되는 순간 useEffect 내의 함수를 실행시킨다.

```
 useEffect(() => {
    console.log(
      "[Function] useEffect [value]: 컴포넌트가 마운트 될 때, + value가 변경되면,"
    );

    const eventHandler = () => {
      console.log("click body");
    };
    document.body.addEventListener("click", eventHandler);

    return () => {
      console.log(
        "[Function] useEffect return [value]: 새로 useEffect를 수행하기 전에,"
      );
    };
    document.body.removeEventListener("click", eventHandler);
  }, [value]);
```

**useEffect의 clean-up 함수**

카운터 컴포넌트가 랜더링 되면서 이벤트들을 계속 생성하므로, 언마운트 되기 전에 사용했던 리소스(이벤트, 객체)를 정리한다.

```
    const eventHandler = () => {
      console.log("click body");
    };
    document.body.addEventListener("click", eventHandler);
```
```
    document.body.removeEventListener("click", eventHandler);
```

순서 : Couner 랜더링 --> 최초의 useEffect 함수 --> 랜더링 --> 새로 useEffect 수행 전, clean-up 함수 --> useEffect 함수 --> 랜더링 --> ... 

### useCallback

**성능 향상을 위한 Hook, 함수 재활용**

최초 랜더링 때 만들어놓은 함수들은 이후, 새로 랜더링할 때 다시 가져와서 사용되지 않고, 다른 메모리에 똑같은 로직의 함수가 새로 쌓인다. 물론 가비지 컬렉터가 지워주지만, 불필요하게 매번 랜더링마다 함수를 생성하는 것은 여전하므로 성능 향상을 위해 useCallback을 사용한다. 

함수를 다시 만드는 것이 아닌, 처음 랜더링 될 때 만들어 놓은 함수를 메모이제이션하여 재활용 하는 것것

```
  const increaseValue = useCallback(() => {
    setValue(value + 1);
  }, [value]);

  return (
    <div>
      <h1>value: {value}</h1>
      <button onClick={increaseValue}>Increase value</button>
    </div>
  );
```
useCallback 함수도 `Dependency List`를 갖는다. 
`Dependency List`에 정의되어 있는 값이 변하면 메모이제이션 해두었던 함수를 지우고 현재 상태에서 함수를 재생성한다.

### Hooks 사용시 주의사항

**1. 조건적 Hooks 사용 불가**

value가 3일때만 useEffect를 걸고 싶으면,
if문으로 감싸지 말고 useEffect 함수 안에 if문을 넣을 것.