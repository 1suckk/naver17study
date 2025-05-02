import React, { useState } from 'react';
import axios from 'axios'; // axios 라이브러리 import
import DaumPostCodeEmbed from 'react-daum-postcode'; // 카카오 주소 검색 라이브러리 import
import { useNavigate } from 'react-router-dom'; // 페이지 이동을 위한 라이브러리 import

const JoinForm = () => {
    const [username, setUserName] = useState(''); // 상태 관리 (useState 훅 사용)
    const [password, setPassword] = useState(''); // 비밀번호 상태 관리
    const [address, setAddress] = useState(''); // 주소 상태 관리
    const [openPostCode, setOpenPostCode] = useState(false); // 주소 검색 팝업 상태 관리

    const [role, setRole] = useState('ROLE_MEMBER'); // 역할 상태 관리
    const [idCheck, setIdCheck] = useState(false); // 아이디 중복 체크 상태 관리, true 일때만 가입이 가능
    
    const navi= useNavigate(); // 페이지 이동을 위한 useNavigate 훅 사용

    //폼 제출 이벤트
    const onSubmit = (e) => {
        e.preventDefault(); // 폼 제출 시 페이지 새로고침 방지
        if(!idCheck) {
            alert('아이디 중복 체크를 해주세요!');
            return;
        }

        //db 저장후 로그인폼으로 이동
        axios.post('/member/join', {username, password, role, address})
        .then(res=>{
            console.log('서버 응답:', res.data);            
            if(res.data==='join success')
            {
                alert(res.data); // 서버 응답 알림
                sessionStorage.removeItem('token');
                navi('/member/login'); // 로그인 페이지로 이동
            }
        }) // axios를 사용하여 서버에 POST 요청
    }

    //username 중복체크 버튼 이벤트
    const btnIdCheck = () => {
        let url="/member/idcheck?username="+username; // 아이디 중복 체크를 위한 URL 설정
        // proxy를 package.json에서 설정한 proxy를 사용하여 백엔드와 통신
        // ==> (http://localhost:8090)로 요청
        axios.get(url)
        .then(res=>{
            if(res.data==='fail'){
                setUserName('');
                setIdCheck(false); 
                alert('사용할 수 없는 아이디입니다!');
            }
            else
            {
                setIdCheck(true); // 중복 체크 성공 시 상태 변경
                alert(res.data+'! 사용 가능한 아이디입니다!');
            }
        })
        .catch(err=>{
            console.error('회원가입 실패: '+ err); // 에러 로그 출력
        });
    };

    //카카오 주소에 대한 이벤트
    const handle={
        clickButton:()=>{
            setOpenPostCode(current=>!current); // 주소 검색 팝업 열기/닫기
        },

        //주소 선택 시
        selectAddress: (data) => {
            console.log(data); // 선택된 주소 데이터 로그 출력

            setAddress(`(${data.zonecode})${data.address}`); // 주소 선택 시 주소 상태 업데이트
            setOpenPostCode(false); // 주소 검색 팝업 닫기
        }
    }

    return (
        <div>
            <h1 className='alert alert-danger' style={{width:'90vw'}}>
                회원가입
            </h1>
            <form onSubmit={onSubmit} style={{width:'70vw'}}>
                    <div className="mb-3">
                        <label htmlFor="username" className="form-label">아이디</label>
                        <input type="text" required className="form-control"
                        value={username}
                        onChange={(e)=>{
                            setIdCheck(false);
                            setUserName(e.target.value)
                        }} placeholder="아이디를 입력하세요"/>
                        <button type='button' className='btn btn-sm btn-danger'
                        onClick={btnIdCheck}>중복체크</button>
                    </div>
                    
                    <div className="mb-3">
                        <label htmlFor="password" className="form-label">비밀번호</label>
                        <input type="password" value={password} 
                        className="form-control" 
                        onChange={(e)=>setPassword(e.target.value)} required
                        placeholder="비밀번호를 입력하세요"/>
                    </div>
                    
                    <div className="mb-3">
                        <label htmlFor="address" className="form-label">주소</label>
                        <input type="text" className="form-control" value={address}
                        onChange={(e)=>setAddress(e.target.value)} required
                        placeholder="주소를 입력하세요"/>
                        <button type='button' className='btn btn-sm btn-danger'
                        onClick={handle.clickButton}>주소검색</button>
                        <br/>
                        {
                            openPostCode &&
                            <DaumPostCodeEmbed
                                onComplete={handle.selectAddress} // 주소 선택 시 호출되는 함수
                                autoClose={false} // 자동 닫기 비활성화
                                defaultQuery="강남대로 94길 20" // 기본 검색어 설정
                            />
                        }
                    </div>

                    <div className="mb-3">
                        <label htmlFor="role" className="form-label">권한 설정</label>
                        <select className='form-select'
                        /* value와 onChange가 있어야 권한이 실제로 db에 적용이 된다 */
                        value={role}
                        onChange={e=>setRole(e.target.value)}>
                            <option value="ROLE_MEMBER">회원</option>
                            <option value="ROLE_ADMIN">관리자</option>
                        </select>
                    </div>
                    <button type='submit' className='btn btn-success'>
                        회원가입
                    </button>
            </form>
        </div>
    );
};

export default JoinForm;