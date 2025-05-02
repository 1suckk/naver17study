import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';

const BoardList = () => {
    const [BoardList, setBoardList] = useState([]);
    const navi=useNavigate();

    //전체 데이터 가져오기
    const getAllDatas=()=>{
        axios.get("/board/list")
        .then(res=>{
            setBoardList(res.data);
        });
    }

    //시작되자마자 리스트 불러오기 위해
    useEffect(()=>{
        getAllDatas();
    })

    return (
        <div>
            <h1 className='alert alert-danger' style={{width:'90vw'}}>
                회원 게시판
            </h1>
            <h3>
            {
                //로그인을 하면 글쓰기 버튼이 보여야 함
                sessionStorage.token==null?"":
                <button type='button' className='btn btn-sm btn-success'
                onClick={()=>navi("/board/form")}>
                    글쓰기
                </button>
            }
            </h3>
            <table className='table table-bordered' style={{width:'800px'}}>
                <caption align="top"><b>
                총 {BoardList.length}개의 글이 있습니다.</b></caption>
                <thead>
                    <tr className='table-info'>
                        <th>번호</th>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>작성일</th>
                        <th>조회수</th>
                    </tr>
                </thead>
                <tbody>
                {
                    BoardList &&
                    BoardList.map((row, idx)=>
                        <tr key={idx} onClick={()=>{
                            if(sessionStorage.token==null)
                                alert("로그인을 먼저 진행해주세요!");
                            else
                                navi(`/board/detail/${row.num}`);
                        }}>
                            <td align='center'>{BoardList.length-idx}</td>
                            <td>
                                {row.subject}
                            </td>
                            <td align='center'>{row.username}</td>
                            <td align='center'>{row.writeday.substring(0,10)}</td>
                            <td align='center'>{row.readcount}</td>
                        </tr>
                    )
                }
                </tbody>
            </table>
        </div>
    );
};

export default BoardList;