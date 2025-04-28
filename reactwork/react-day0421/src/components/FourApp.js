import React from "react";

const FourApp = () => {

    return (
        <div>
            <h3>결제방법을 선택하세요.</h3>
            <select>
                <option value="now">일시불</option>
                <option value="3month">3개월 할부</option>
                <option value="6month">6개월 할부</option>
                <option value="9month">9개월 할부</option>
                <option value="12month">12개월 할부</option>
                <option value="18month">18개월 할부</option>
                <option value="24month">24개월 할부</option>
            </select>
            
        </div>
    );
};

export default FourApp;