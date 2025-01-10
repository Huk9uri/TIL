import Memocontainer from "./components/MemoContainer/MemoContainer"
import SideBar from "./components/SideBar/SideBar"
import './App.css';
import { useState } from "react";
function App() {
  const [memos, setMemos] = useState([
    {
      title: 'Memo 1',
      content : 'This is Memo Content 1',
      createdAt : 1736485409721,
      updatedAt : 1736485442545,
    },
    {
      title: 'Memo 2',
      content : 'This is Memo Content 2',
      createdAt : 1736485471841,
      updatedAt : 1736485474347,
    },
  ]);

  const [selectedMemoIndex, setSelectedMemoIndex] = useState(0);

  const setMemo = (newMemo)=>{
    const newMemos = [...memos];

    memos[selectedMemoIndex] = newMemo;
    
    console.log('memo' , memos)

    setMemos([newMemos]);
  }
  
  return (
    <div className = 'App'>
      <SideBar memos = {memos} />
      <Memocontainer memo = {memos[selectedMemoIndex]} setMemo = {setMemo}/>
    </div>
  )
}

export default App
