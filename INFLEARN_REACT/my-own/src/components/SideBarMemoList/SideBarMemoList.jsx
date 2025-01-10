function SideBarMemoList({memos}){
    return <div>{
        memos.map(item => {
            return <div key = {item.createdAt}> {item.title} </div>
        })}
        
    </div>;
}

export default SideBarMemoList;