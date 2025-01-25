function ActionButtons({ questionLength, step }) {
  //TODO : 버튼 한 줄로 줄이기
  // && 봐주세요
  return (
    <>
      <div>{step != 0 && <button>이전</button>}</div>
      <div>
        {step === questionLength - 1 ? (
          <button>제출</button>
        ) : (
          <button>다음</button>
        )}
      </div>
    </>
  );

  //    {
  //     return (
  //       <div>
  //         <button>이전</button>
  //       </div>
  //     );
  //   }
  //   return (
  //     <>
  //       <button>다음</button>

  //       <button>제출</button>
  //     </>
  //   );
}

export default ActionButtons;
