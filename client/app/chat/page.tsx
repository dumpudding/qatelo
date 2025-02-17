"use client";

import React, { useState } from "react";
import Image from "next/image";

const Chat = () => {
  const [isSidebarOpen, setIsSidebarOpen] = useState(false);

  return (
    <div className="flex h-screen bg-white">
      {/* Sidebar (Expandable) */}
      <div
        className={`fixed top-0 left-0 h-full w-64 bg-[#355E3B] shadow-lg transform ${
          isSidebarOpen ? "translate-x-0" : "-translate-x-full"
        } transition-transform duration-300 ease-in-out`}
      >
        {/* Back Button */}
        <div className="p-4 flex items-center justify-between">
          <button onClick={() => setIsSidebarOpen(false)} className="text-white text-2xl">
            ←
          </button>
        </div>

        {/* Chat List */}
        <div className="space-y-4 p-4">
          {["ome", "Helena D.", "Gordon G. B.", "octo"].map((name, index) => (
            <div key={index} className="flex items-center bg-gray-300 p-2 rounded-lg">
              <Image
                src="/design_folder/profile.png" // Placeholder profile image
                alt="Profile"
                width={40}
                height={40}
                className="rounded-full"
              />
              <p className="ml-3 text-black text-sm">{name}</p>
            </div>
          ))}
        </div>

        {/* New Chat Button */}
        <div className="absolute bottom-4 left-4 right-4">
          <button className="w-full bg-black text-white p-3 rounded-lg">New Chat</button>
        </div>
      </div>

      {/* Main Chat Window */}
      <div className="flex flex-1 flex-col">
        {/* Header */}
        <div className="flex items-center bg-[#355E3B] p-4">
          {/* Menu Button (Opens Sidebar) */}
          <button onClick={() => setIsSidebarOpen(true)} className="text-white text-2xl">
            ☰
          </button>

          {/* Active Chat User */}
          <div className="ml-4 flex items-center space-x-2">
            <Image
              src="/design_folder/profile.png"
              alt="Active User"
              width={40}
              height={40}
              className="rounded-full border-2 border-yellow-500"
            />
            <p className="text-white text-lg">ome</p>
          </div>
        </div>

        {/* Chat Messages Area */}
        <div className="flex-1 bg-white"></div>

        {/* Chat Input */}
        <div className="flex items-center bg-gray-300 p-3 relative">
          {/* Bear Character */}
          <Image
            src="/design_folder/bear.png"
            alt="Bear"
            width={40}
            height={40}
            className="absolute left-2 bottom-1"
          />

          {/* Input Field */}
          <input
            type="text"
            placeholder="type something..."
            className="flex-1 bg-gray-200 p-2 pl-12 rounded-md"
          />

          {/* Send Button */}
          <button className="ml-2 bg-[#355E3B] p-2 rounded-md">
            <Image src="/design_folder/panda.png" alt="Panda" width={40} height={40} />
          </button>
        </div>
      </div>
    </div>
  );
};

export default Chat;
