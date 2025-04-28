import React from 'react';
import { Alert } from '@mui/material';
import { useParams } from 'react-router-dom';

const Food = () => {
    const {food1, food2} = useParams();

    return (
        <div>
            <Alert severity='success'
            style={{ fontSize: '20px' }}>Food 컴포넌트</Alert>
            {
                food1==null && food2==null?
                <div>
                    <h1>스낵바로 운영됩니다.</h1>
                    <img alt="" src={require("../image/josik.jpg")} width="500" height="300" />;
                </div>
                :
                food1!=null && food2==null?
                <div>
                    <h1>식사는 제공됩니다. 후식은 제공되지 않습니다.</h1>
                    <img alt="" src={require("../image/jungsik.jpg")} width="500" height="300" />;
                </div>
                :
                <div>
                    <h1>석식: 식사가 제공됩니다. 후식도 제공합니다.</h1>
                    <img alt="" src={require("../image/seoksik.jpg")} width="500" height="300" />;
                </div>
            }
        </div>
    );
};

export default Food;