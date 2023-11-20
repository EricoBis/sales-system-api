import React from "react";

function ContentContainer({ children }: { children: React.ReactNode }) {
  return <div className="sm:m-20 m-10">{children}</div>;
}

export default ContentContainer;
