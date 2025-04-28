import React, { useState, useEffect } from 'react';
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
    const addurl = "http://localhost:8090/react/addshop";
    
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
        axios.delete(deleteurl)
        .then(res=>list()); //삭제 성공 후 다시 목록 출력
    }

    useEffect(()=>{
        list(); //처음 시작 시에 한번만 실행
    },[]); //처음 시작 시에 한번만 실행 

    return (
        <div>
            <Alert severity='success' style={{fontSize:'25px'}}>
                상품 데이터 조회
            </Alert> 
            <FourWriteShop onSave={addShopEvent} /> 
            <hr/>
            <h5>총 {shoplist.length}개의 상품이 있습니다.</h5>
            <table className='table table-bordered' style={{width:'500px'}}>
                <tbody>
                {
                    shoplist
                    &&
                    shoplist.map((row, idx)=>
                        //key는 반드시 있어야 함
                        //row={row}는 props로 전달됨
                        //onDelete={onDelete}는 props로 전달됨
                        //onDelete는 삭제하는 함수
                        //row.num은 삭제할 상품의 번호
                        <FourRowItems key={idx} row={row} onDelete={onDelete}/>
                    )
                }
                </tbody>
            </table>
        </div>
    );
};

export default FourApp;