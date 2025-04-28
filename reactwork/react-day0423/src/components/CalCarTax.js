import {Alert} from '@mui/material';
import React, { useState } from 'react';

const CalCarTax = () => {
    
    const [carIdx, setCarIdx] = useState("non_light"); //차종 구분
    const [humanIdx, setHumanIdx] = useState("normal"); //장애인(국가유공자), 일반인 구분
    const [carPrice, setCarPrice] = useState(""); //차량가격 입력값
    const [result, setResult] = useState("");

    //개별소비세 계산 함수
    const CalCarGaesose = () => {
        let output="";
        if(carIdx === 'light')
        {
            output="0원";
        }

        //경차가 아니라면,
        else
        {
            if(humanIdx==="normal")
            {
                const price = parseFloat(carPrice.replace(/,/g, ""));
                if(isNaN(price))
                {
                    output="차량가격을 숫자로 입력하세요.";
                }
                else
                {
                    output=`${Math.round(price*0.05).toLocaleString()}원`;
                }
            }
            else
            {
                output="0원";
            }
        }

        setResult(output);
    }

    //입력값 초기화 버튼 누르면 다시 초기화 되도록 하는 함수
    const resetInput = () => {
        setCarIdx("non_light");
        setHumanIdx("normal");
        setCarPrice("");
        setResult("");
    };

    return (
        <div>
            <Alert severity='success'>차량 개소세 계산기</Alert>
            <table className='table table-bordered' style={{width:'300px',margin:'30px 30px'}}>
                <tbody>
                    <tr>
                        <th className='table-success' width="100">이름</th>
                        <td>
                            <select className='form-select' style={{margin:'10px'}}
                            onChange={(e)=>{setCarIdx(e.target.value)}}>
                                <option value={"non_light"}>경차 제외</option>
                                <option value={"light"}>경차</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th className='table-success' width="100">이름</th>
                        <td>
                            <select className='form-select' style={{margin:'10px'}}
                            onChange={(e)=>{setCarIdx(e.target.value)}}>
                                <option value={"normal"}>일반인</option>
                                <option value={"handicap"}>장애인</option>
                                <option value={"nationalMerit"}>국가유공자</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th className='table-success' width="100">차량가격</th>
                        <td>
                            <input type='text' value={carPrice}
                            onChange={(e)=>{
                                const onlyNumber = e.target.value.replace(/[^0-9]/g, '')//숫자만 입력
                                const number = Number(onlyNumber);
                                setCarPrice(onlyNumber === '' ? '' : number.toLocaleString('ko-KR'));
                            }}
                            />
                        </td>
                    </tr>
                    <tr>
                        <td colSpan={2} align='center'>
                            <button onClick={CalCarGaesose}>개소세 조회</button>
                            <button onClick={resetInput}>입력값 초기화</button>
                        </td>
                    </tr>
                </tbody>
            </table>
            <div style={{
                whiteSpace:'pre-line',
                marginLeft:'30px',
                width:'300px'
            }}
            className='alert alert-info'>
                {result}
            </div>
        </div>
    );
};

export default CalCarTax;