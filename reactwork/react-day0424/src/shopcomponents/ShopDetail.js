import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import axios from 'axios';
import {Alert} from '@mui/material';

const ShopDetail = () => {
    const[selectData, setSelectData] = useState('');

    const {num} = useParams();

    //num에 해당하는 데이터 가져오기
    const getSelectData = () => {
        let getUrl = "/react/detail?num=" + num;
        axios.get(getUrl)
        .then(res=>setSelectData(res.data))
    }

    //처음 로딩시 함수호출
    useEffect(()=>getSelectData(),[]);

    return (
        <div>
            <Alert severity='info'>상세정보</Alert>
        </div>
    );
};

export default ShopDetail;