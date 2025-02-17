"use client";

import React, { useState, useEffect } from "react";
import { useRouter } from "next/navigation";

const Notifications = () => {
  const router = useRouter();

  // Load notifications from localStorage
  const [notifications, setNotifications] = useState<{ id: number; sender: string; message: string }[]>([]);

  useEffect(() => {
    const storedNotifs = JSON.parse(localStorage.getItem("notifications") || "[]");
    setNotifications(storedNotifs);
  }, []);

  // Function to remove a notification
  const removeNotification = (id: number) => {
    const updatedNotifs = notifications.filter((notif) => notif.id !== id);
    setNotifications(updatedNotifs);
    localStorage.setItem("notifications", JSON.stringify(updatedNotifs));

    // If all notifications are gone, return to home page
    if (updatedNotifs.length === 0) {
      setTimeout(() => {
        router.push("/home"); // Changed to "/home" instead of "/"
      }, 500);
    }
  };

  return (
    <div className="min-h-screen flex bg-white">
      {/* Sidebar */}
      <div className="w-20 bg-yellow-300 flex items-start p-4">
        {/* Updated: Navigate Back to Home Page */}
        <button onClick={() => router.push("/home")} className="text-red-600 text-3xl">
          ❌
        </button>
      </div>

      {/* Notification Panel */}
      <div className="flex-1 p-8">
        <h1 className="text-2xl font-bold">Notifications</h1>

        <div className="bg-gray-300 p-4 mt-4 rounded-lg h-[400px] overflow-y-auto"> {/* Set height and enable scrolling */}
          {notifications.length > 0 ? (
            notifications.map((notif) => (
              <div key={notif.id} className="flex items-center justify-between bg-white p-3 my-2 rounded-md shadow-sm transition-all duration-300">
                <p className="flex-1 text-sm">
                  <span className="font-bold">{notif.sender}: </span>
                  {notif.message}
                </p>

                {/* Delete Notification */}
                <button onClick={() => removeNotification(notif.id)} className="text-red-600 text-lg hover:scale-110 transition">
                  ❌
                </button>
              </div>
            ))
          ) : (
            <p className="text-center text-gray-600 mt-4">No notifications left.</p>
          )}
        </div>
      </div>
    </div>
  );
};

export default Notifications;
