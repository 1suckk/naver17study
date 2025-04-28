import React from 'react';

const SevenApp = () => {
    return (
        <div>
            <h3 className='alert alert-success'>자동차 세금 조회</h3>
            <div className='main'>
                <h4>현재 표시가격</h4>
                <div className='input'>
                    <span className='title'>가격  </span>
                    <input type='text' name='before' value={"20,000,000"}></input>
                    <span className='unit'>  원</span>
                </div>
            </div>
        </div>
    );
};

export default SevenApp;