import React, { useState } from 'react';

const TwoApp = () => {

    const [selectedInsOption, setSelectedInsOption] = useState('기본 보험');

    const handleChange = (e) => {
        setSelectedInsOption(e.target.value);
    }

    return (
        <div>
            <h3 className='alert alert-success'>자동차보험 가입</h3>
            {selectedInsOption === '기본 보험' && (
            <h5 id="ins_basic">
                자동차 책임보험은 자동차 운행으로 인해 다른 사람에게 사망, 부상, 재물 손실 등을
                입힌 경우에 피해자에게 손해 배상을 보장하기 위해 법적으로 의무화된 보험입니다.
                이 보험은 대인배상I과 대물배상으로 구성되며, 대물배상은 최소 2천만원 이상 가입해야 합니다. 
                <br></br>
                자동차 책임보험의 주요 내용:<br></br>
                대인배상I:<br></br>
                자동차 사고로 인해 타인이 사망하거나 부상한 경우에 대한 손해 배상을 보장합니다. <br></br>
                대물배상:<br></br>
                자동차 사고로 인해 타인의 차량이나 재물이 파손된 경우에 대한 손해 배상을 보장합니다.
                대물배상은 2천만원 이상 가입해야 합니다.<br></br>
                의무보험:<br></br>
                자동차를 운행하는 모든 사람은 자동차 책임보험에 가입해야 합니다. <br></br>
                과태료:<br></br>
                책임보험 미가입 시 과태료가 부과될 수 있습니다. <br></br>
                자동차 책임보험은 자동차 사고로 인한 피해자를 보호하고, 운전자에게 손해 배상 책임으로부터
                자유롭게 하기 위해 필요한 보험입니다.
                <br></br><br></br>
            </h5>
            )}

            {selectedInsOption === '기본 보험 ++ 대인' && (
            <h5 id="ins_human">
                기본 보험에서 대인배상2를 추가한 상품입니다.
                <br></br><br></br> 
            </h5>
            )}

            {selectedInsOption === '기본 보험 ++ 대물' && (
            <h5 id="ins_thing">
                기본 보험에서 2천만원 ~ 10억원 대물배상을 추가한 상품입니다.
            </h5>
            )}
            
            <select style={{width:'200px'}} value={selectedInsOption}
            onChange={handleChange}>    
                <option>기본 보험</option>
                <option>기본 보험 ++ 대인</option>
                <option>기본 보험 ++ 대물</option>
            </select><br></br>
            <button>신청하기</button>
        </div>
    );
};

export default TwoApp;