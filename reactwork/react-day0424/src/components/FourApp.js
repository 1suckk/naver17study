import React, { useState } from 'react';
import {Alert} from '@mui/material';
import axios from 'axios';
import FourWriteShop from './FourWriteShop';
import FourRowItems from './FourRowItems';


const FourApp = () => {
    /* axios를 이용해서 서버와 통신할 것
    axios.get('url주소').then().catch();
    axios.post('url주소').then().catch();
    또는 
    axios({
        method:'get',
        url:'url주소'
        ...
    }) */

    const [shoplist, setShoplist]=useState([]);
    const addurl = "/react/addshop";
    
    //추가하는 함수
    const addShopEvent=(shopdata)=>{
        axios.post(addurl, shopdata)
        .then(res=>{
            list();
        }).catch(error=>console.log("insert 오류:"+error));
    }

    //db에서 데이터를 가져오는 함수
    const list=()=>{
        axios.get("/react/shoplist")
        .then(res=>setShoplist(res.data));
    }

    //삭제하는 함수
    const onDelete=(num)=>{
        let deleteurl="/react/shopdelete?num="+num;
    }

    return (
        <div>
            <Alert severity='success' style={{fontSize:'25px'}}>
            상품 데이터 조회
            </Alert> 
            <FourWriteShop onSave={addShopEvent}/>
            <hr/>
            <h5>총 {shoplist.length}개의 상품이 있습니다.</h5>
            <FourRowItems/>
        </div>
    );
};

export default FourApp;