import React, {useState} from 'react';
import {Alert} from '@mui/material';
import OneRowItem from './OneRowItem';
import OneWriteForm from './OneWriteForm';

const OneApp = () => {
    const [dataArray, setDataArray]=useState(
        [
            {
                irum:'장성태',
                rate:'대표이사',
                photo:'1.jpg',
                Inyear:'1985'
            },
            {
                irum:'이중무',
                rate:'전무이사',
                photo:'2.jpg',
                Inyear:'1986'
            },
            {
                irum:'김장영',
                rate:'부장',
                photo:'3.jpg',
                Inyear:'2000'
            }
        ]
    );

    const dataAddEvent=(data)=>{
        setDataArray(dataArray.concat({
            ...data}));
    };

    //삭제하는 함수
    const deleteData=(idx)=>{
        setDataArray(dataArray.filter((d,i)=>idx!==i));
    }
    
    return (
        <div style={{width:'500px'}}>
            <Alert severity='success'
            style={{fontSize:'25px'}}>
                임직원 조회
            </Alert>
            {/* 데이터 입력 */}
            <OneWriteForm onSave={dataAddEvent}/>

            {/* 데이터 출력  */}
            <table className='table table-bordered'>
                <thead>
                    <tr className='table-danger'>
                        <th width="50">성명</th>
                        <th width="150">직위</th>
                        <th width="120">입사년도</th>
                        <th>삭제</th>
                    </tr>
                </thead>
                <tbody>
                {
                    dataArray.map((row,idx)=> 
                        //여기서 파라미터를 제대로 안넣으면 계속 에러 난다
                        <OneRowItem key={idx} row={row} idx={idx}
                        onDelete={deleteData}/>)
                }   
                </tbody>
            </table>
        </div>
    );
};

export default OneApp;