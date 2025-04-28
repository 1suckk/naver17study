import React, { useCallback, useState } from 'react';
import SevenLight from './SevenLight';

const SevenSmartHome = () => {
    const [masterOn, setMasterOn] = useState(false);
    const [kitchenOn, setKitchenOn] = useState(false);
    const [livingRoomOn, setLivingRoomOn] = useState(false);

    //버튼 한개만 눌러도 3개의 서브 컴포넌트가 모두 호출됨
    //useCallback을 사용하여 최적화
    // const toggleMaster = () => {
    //     setMasterOn(!masterOn); // Toggle master switch
    // };

    // const toggleKitchen = () => {
    //     setKitchenOn(!kitchenOn); // Toggle kitchen light
    // };

    // const toggleLivingRoom = () => {
    //     setLivingRoomOn(!livingRoomOn); // Toggle living room light
    // };
    const toggleMaster = useCallback(() => {
        setMasterOn(!masterOn); // Toggle master switch
        }, [masterOn]); // useCallback to memoize the function
    

    const toggleKitchen = useCallback(() => {
        setKitchenOn(!kitchenOn); // Toggle Kitchen switch
        }, [kitchenOn]); // useCallback to memoize the function

    const toggleLivingRoom = useCallback(() => {
        setLivingRoomOn(!livingRoomOn); // Toggle living room switch
        }, [livingRoomOn]); // useCallback to memoize the function

    return (
        <div>
            <SevenLight room={'침실'} on={masterOn} toggle={toggleMaster} />
            <SevenLight room={'주방'} on={kitchenOn} toggle={toggleKitchen} />
            <SevenLight room={'거실'} on={livingRoomOn} toggle={toggleLivingRoom} />
        </div>
    );
};

export default SevenSmartHome;