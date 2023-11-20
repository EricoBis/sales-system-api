import { useState, useEffect } from "react";
import { FaRegCheckCircle } from "react-icons/fa";

interface AlertSuccessProps {
  message: string;
  displayTime?: number;
}

const SuccessAlert: React.FC<AlertSuccessProps> = ({
  message,
  displayTime = 5000,
}) => {
  const [showAlert, setShowAlert] = useState(true);

  useEffect(() => {
    const timer = setTimeout(() => {
      setShowAlert(false);
    }, displayTime);

    return () => {
      clearTimeout(timer);
    };
  }, [displayTime]);

  return (
    <div
      className={`mt-14 fixed top-4 left-1/2 transform -translate-x-1/2 bg-green-100 rounded-lg p-4 shadow-lg ${
        showAlert ? "block" : "hidden"
      }`}
    >
      <div className="flex flex-row items-center">
        <FaRegCheckCircle className="h-6 w-6 text-green-700" />
        <p className="text-green-700">{message}</p>
      </div>
    </div>
  );
};

export default SuccessAlert;
