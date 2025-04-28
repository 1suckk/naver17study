import {Alert} from '@mui/material';
import React from 'react';

/*
금융사기 방지 퀴즈
2열 5행으로
1열에는 금융사기 방지를 위한 퀴즈문제 제공
2열에는 지울수 있는 버튼이 있는 답이 적힌 덩어리가 있음
좌측 상단에는 초기화 버튼, 우측 상단에는 답 지우기 버튼
특정 단어로 검색을 하면 특정 단어가 포함된 리뷰만 보인다
해당 검색기록을 더블클릭하면 자동차를 삭제할까요 confirm이 뜨도록 하고 확인을 누르면 삭제되도록 한다 filter 이용해서
*/
const FinQuiz = () => {
    return (
        <div>
            <Alert severity='success'>3번 페이지</Alert>
            <div style={{margin:'30px 30px'}}>
                <button>초기화</button>
                <button>답 지우기</button>
            </div>
            <table className='table table-bordered' style={{width:'1200px', margin:'30px 30px'}}>
                <tbody>
                <tr>
                        <th className='table-success' width="400">거치기간의 의미는?</th>
                        <td>
                            대출이자 납입에서 제외되는 기간
                        </td>
                    </tr>
                    <tr>
                        <th className='table-success' width="400">이름</th>
                        <td>
                           
                        </td>
                    </tr>
                    <tr>
                        <th className='table-success' width="400">차량가격</th>
                        <td>
                            
                        </td>
                    </tr>
                    <tr>
                    <th className='table-success' width="400">차량가격</th>
                        <td>

                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    );
};

export default FinQuiz;