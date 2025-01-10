import './MemoContainer.css'
function Memocontainer({memo, setMemo}){
    return (
    <div className = "MemoContainer">
        <div>
            <input type = 'text' className = 'MemoContainer_title' placeholder='Untitled' value = {memo.title}
            onChange={(e) =>{
                setMemo({...memo,
                    title : e.target.value,
                    updatedAt: new Date().getTime(),
                })
            }}></input>
        </div>

        <div>
            <textarea className= 'MemoContainer_content' value = {memo.content} onChange={(e)=>{
                setMemo({...memo,
                    content : e.target.value,
                    updatedAt: new Date().getTime(),
                });
            }}>
            </textarea>
        </div>
    </div>
    )
}

export default Memocontainer;