"use client";

import React, { useEffect, useState } from "react";
import Link from "next/link";
import Image from "next/image";

const Home = () => {
  // Get notifications from localStorage (sync with Notifications page)
  const [notifications, setNotifications] = useState<{ id: number; sender: string; message: string }[]>([]);

  useEffect(() => {
    // Load notifications from localStorage
    const storedNotifs = JSON.parse(localStorage.getItem("notifications") || "[]");
    setNotifications(storedNotifs);
  }, []);

  return (
    <div className="min-h-screen flex bg-white relative">
      {/* Sidebar */}
      <div className="w-20 bg-yellow-300"></div>

      {/* Main Content */}
      <div className="flex-1 p-8">
        <h1 className="text-3xl font-bold">Hi, <span className="text-gray-700">[user_name]</span>.</h1>

        {/* Top Right Section (Buttons next to the Yellow Sidebar) */}
        <div className="absolute top-6 left-20 flex items-center space-x-4">
          {/* Help Button */}
          <button className="bg-gray-200 text-white px-4 py-2 rounded-md text-sm w-24">Help</button>

          {/* Profile Button */}
          <button className="bg-green-700 text-white px-4 py-2 rounded-md text-sm w-24">Profile</button>
        </div>

        {/* Notifications Panel */}
        <div className="absolute top-20 right-6 bg-gray-300 p-4 rounded-lg w-72">
          <div className="flex justify-between items-center mb-2">
            <h2 className="text-lg font-bold">Notifications</h2>

            {/* Button to Open Notifications Page */}
            <Link href="/notifications">
              <button className="bg-green-700 text-white w-6 h-6 flex items-center justify-center rounded-full text-xl">
                +
              </button>
            </Link>
          </div>

          {/* Notification List */}
          {notifications.length > 0 ? (
            <div className="space-y-2">
              {notifications.map((notif) => (
                <div key={notif.id} className="bg-white p-2 rounded-md">
                  <p className="text-sm">
                    <span className="font-bold">{notif.sender}: </span>
                    {notif.message}
                  </p>
                </div>
              ))}
            </div>
          ) : (
            <p className="text-center text-gray-600 mt-2">No notifications.</p>
          )}
        </div>
      </div>
    </div>
  );
};

export default Home;
