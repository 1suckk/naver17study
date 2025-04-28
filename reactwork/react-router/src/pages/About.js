import React from 'react';
import { Alert } from '@mui/material';
import { NavLink, useParams } from 'react-router-dom';

const About = () => {
    const {emp}=useParams();

    return (
        <div>
            <Alert severity='success'
            style={{ fontSize: '20px' }}>About 컴포넌트</Alert>

            {
            emp==null?
                <div>
                    <h1>직급별 식사제공 여부</h1>
                    <div>
                        <ul className='menu'>
                            <li>
                                <NavLink to="/about/temporary">계약직 직원</NavLink>
                            </li>
                            <li>
                                <NavLink to="/about/employee">정규직 직원</NavLink>
                            </li>
                            <li>
                                <NavLink to="/about/executive">임원</NavLink>
                            </li>
                        </ul>
                    </div>
                </div>
            :
            emp==="temporary"?
                    <div>
                        <h1>{emp}:계약직 직원은 중식만 제공됩니다.</h1>
                    
                </div>
            :
            emp==="employee"?
                <div>
                    <h1>{emp}:정규직 직원은 조식, 중식만 제공됩니다.</h1>
                </div>
            :
                <div>
                    <h1>{emp}:임원은 조식, 중식, 석식 모두 제공됩니다.</h1>
                </div>
            }
        </div>
    )
};

export default About;