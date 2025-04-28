import {Alert} from '@mui/material';
import React from 'react';
/* 
광고 의뢰받은 회사들로부터의 광고가 있다
이걸 부모와 자식 간의 컴포넌트 간 통신을 활용해서 
SubEightApp을 자식 컴포넌트로 삼아서 사용하라
부모에서 자식으로 prop 을 통해서 값이나 이벤트 전달이 가능
자식은 부모의 값을 prop으로 받아서 출력은 가능하나 직접적 변경은 불가
클릭한 횟수에 따라서 광고비를 상단에서 실시간으로 볼 수 있도록 하라
 */
const EightApp = () => {
    return (
        <div>
            <Alert severity='success'>광고 페이지</Alert>
        </div>
    );
};

export default EightApp;