import React from 'react';
import Menu from './Menu';
import { Route, Routes } from 'react-router-dom';
import Home from '../components/Home';
import OneApp from '../components/OneApp';
import TwoApp from '../components/TwoApp';
import ThreeApp from '../components/ThreeApp';
import FourApp from '../components/FourApp';
import FiveApp from '../components/FiveApp';
import SixApp from '../components/SixApp';
import SevenApp from '../components/SevenApp';
import EightApp from '../components/EightApp';

const RouterMain = () => {
    return (
        <div>
            <Menu />
            <br style={{clear: "both"}}/>
            <div style={{margin:'10px'}}>
                <Routes>
                    <Route path='/' element={<Home/>}/>
                    <Route path='/one' element={<OneApp/>}/>
                    <Route path='/two' element={<TwoApp/>}/>
                    <Route path='/three' element={<ThreeApp/>}/>
                    <Route path='/four' element={<FourApp/>}/>
                    <Route path='/five/*' element={<FiveApp/>}/>
                    <Route path='/six' element={<SixApp/>}/>
                    <Route path='/seven' element={<SevenApp/>}/>
                    <Route path='/eight/*' element={<EightApp/>}/>
                </Routes>
            </div>
        </div>
    );
};

export default RouterMain;
