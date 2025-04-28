import React from "react";
import OneApp from "./OneApp";
import TwoApp from "./TwoApp";
import ThreeApp from "./ThreeApp";
import FourApp from "./FourApp";
const MainApp=()=>{
    return (
        <div>
            <h3 className="alert alert-danger">비트상사 - 전기차 구매</h3>
            <OneApp/>
            <hr/>
            <TwoApp/>
            <hr/>
            <ThreeApp/>
            <hr/>
            <FourApp/>
        </div>
    )
}
export default MainApp;