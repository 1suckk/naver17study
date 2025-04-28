import React from 'react';
import {NavLink} from 'react-router-dom';
import "./mystyle.css";

const Menu = () => {
    return (
        <div>
            <ul className='menu'>
                <li>
                    <NavLink to={"/"}>Home</NavLink>
                </li>
                <li>
                    <NavLink to={"/login"}>Login</NavLink>
                </li>
                <li>
                    <NavLink to={"/about"}>About</NavLink>
                </li>
                <li>
                    <NavLink to={"/about/temporary"}>계약직 직원</NavLink>
                </li>
                <li>
                    <NavLink to={"/about/employee"}>정규직 직원</NavLink> 
                </li>
                <li>
                    <NavLink to={"/about/executive"}>임원</NavLink>
                </li>
                <li>
                    <NavLink to={"/food"}>조식</NavLink>
                </li>
                <li>
                    <NavLink to={"/food/food1"}>중식</NavLink>
                </li>
                <li>
                    <NavLink to={"/food/food1/food2"}>석식</NavLink>
                </li>
            </ul>
        </div>
    );
};

export default Menu;