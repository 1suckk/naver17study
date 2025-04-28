import React from 'react';

const SevenLight = ({room,on,toggle}) => {
    return (
        <div>
            <button onClick={toggle}>
                {room} {on ? "💡" : "⬛"}
            </button>
        </div>
    );
};

export default React.memo(SevenLight); // React.memo to prevent unnecessary re-renders
// React.memo to prevent unnecessary re-renders