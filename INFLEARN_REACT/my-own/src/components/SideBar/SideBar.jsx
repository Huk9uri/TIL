import SideBarFooter from "../SideBarFooter/SideBarFooter";
import SideBarHeader from "../SideBarHeader/SideBarHeader";
import SideBarMemoList from "../SideBarMemoList/SideBarMemoList";

function SideBar({memos}){
    return <div className = "SideBar">
        <SideBarHeader/>
        <SideBarMemoList memos = {memos}/>
        <SideBarFooter/>
        </div>;
}

export default SideBar;