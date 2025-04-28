//단축키 rsf
// import React from 'react';

// function TwoApp(props) {
//     return (
//         <div>
            
//         </div>
//     );
// }

// export default TwoApp;

//단축키 rsc
import React from 'react';
import niro from "./02_niro.png";

const TwoApp = () => {
    let msg = "가격: 1천만원";
    return (
        <div>
            <h2>기아 Niro EV</h2>
            <img alt="" src={niro} />
            {msg}
        </div>
    );
};

export default TwoApp;