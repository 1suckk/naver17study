import axios from 'axios';
import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

const BoardForm = () => {
    const [subject, setSubject] = useState('');
    const [content, setContent] = useState('');
    const [photo, setPhoto] = useState(null);
    const [username, setUsername] = useState('');

    const navi = useNavigate();

    const onSaveSubmit=(e)=>{
        //새로고침 방지
        e.preventDefault();

        const formData = new FormData(); //선언 후 각 요소를 추가해줘야

        formData.append('subject', subject);
        formData.append('content', content);
        formData.append('upload', photo);

        //db 저장 후 리스트 페이지로 이동
        axios.post('/auth/board/insert', formData, {
            headers:
            {
                'Content-Type':'multipart/form-data',
                'Authorization':'Bearer '+sessionStorage.getItem('token')
            }
        })
        .then(res=>{
            navi('/board/list');
        });
    };

    return (
        <div>
            <h1 className='alert alert-danger' style={{width:'90vw'}}>
                회원 글쓰기
            </h1>
            <form onSubmit={onSaveSubmit} style={{width:'90vw'}}>
                <div className='mb-3'>
                    <label className='form-label'>제목</label>
                    <input type='text' required className='form-control'
                    value={subject}
                    onChange={(e)=>{
                        setSubject(e.target.value)
                    }} placeholder='제목을 입력하세요'/>
                </div>
                <div className='mb-3'>
                    <label className='form-label'>내용</label>
                    <textarea required className='form-control'
                    value={content}
                    style={{height:'500px'}}
                    onChange={(e)=>{
                        setContent(e.target.value)
                    }}/>
                </div>
                <div className='mb-3'>
                    <input type='file' name='upload' className='form-control'
                    required 
                    onChange={e=>setPhoto(e.target.files[0])}
                    />
                </div>
                <button type='submit' className='btn btn-success'>
                    글쓰기
                </button>
            </form>
        </div>
    );
};

export default BoardForm;